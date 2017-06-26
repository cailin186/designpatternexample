package com.javapatterns.singleton.mxrecord;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import java.util.StringTokenizer;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

import javax.naming.NamingEnumeration;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.Attributes;
import javax.naming.directory.Attribute;

public class MXList1
{
    private static MXList1 mxl = null;
    private Vector list = null;

    private static final String FACTORY_ENTRY =
        "java.naming.factory.initial";

	private static final String FACTORY_NAME =
        "com.sun.jndi.dns.DnsContextFactory";

	private static final String PROVIDER_ENTRY =
        "java.naming.provider.url";

    private static final String MX_PREFIX = "MX";

    private String providerUrl = null;
    private String domainName = null;
    private static Calendar updateTime ;

    /**
     * @link aggregationByValue
     * @directed
     * @clientCardinality 1
     * @supplierCardinality * 
     */
    private MailServer lnkMailServer;

    private MXList1() {}

    private MXList1(String providerUrl,
	    String domainName) throws Exception
    {
        this.providerUrl = providerUrl;
        this.domainName = domainName;
	
		this.list = getMXRecords(providerUrl, domainName);
    }

    public static synchronized MXList1 getInstance(
        String providerUrl,
	    String domainName) throws Exception
    {
        if (mxl == null)
        {
			mxl = new MXList1(providerUrl, domainName);
        }
		else
        {
            Calendar now = new GregorianCalendar();

			long TimeDifference = now.getTime().getTime()
                - updateTime.getTime().getTime() ;

            System.out.println("TimeDifference" + TimeDifference);
            if (TimeDifference  > 1)
            {
				mxl.list = mxl.getMXRecords(providerUrl, domainName);
            }
        }
        return mxl;
    }

    public MailServer elementAt(int index)
        throws Exception
    {
        return (MailServer) list.elementAt(index);
    }

    public int size()
    {
        return list.size();
    }

    private Vector getMXRecords(
        String providerUrl,
	    String domainName) throws Exception
    {
        Hashtable env = new Hashtable();
        
        env.put(FACTORY_ENTRY, FACTORY_NAME);
        env.put(PROVIDER_ENTRY, providerUrl);
        
        DirContext dirContext = new InitialDirContext(env);
        
        Vector records = new Vector(10);
        
        Attributes attrs = dirContext.getAttributes(
	        domainName, 
	        new String[] {MX_PREFIX});
        
        for(NamingEnumeration ae = attrs.getAll(); 
	        ae != null && ae.hasMoreElements();) 
        {
            Attribute attr = (Attribute)ae.next();
            NamingEnumeration e = attr.getAll();
            while(e.hasMoreElements()) 
            {
                String element = e.nextElement().toString();

//                System.out.println("element = " + element);

                StringTokenizer tokenizer = 
                	new StringTokenizer(element, " ");
                
                MailServer mailServer = new MailServer();
                
                String token1 = tokenizer.nextToken();
                String token2 = tokenizer.nextToken();
                
                if(token1 != null && token2 != null) 
                {
                    mailServer.setPriority(
	                    Integer.valueOf(token1).intValue());
                    mailServer.setServer(token2);
                    records.addElement(mailServer);
                }
            }
        }

        updateTime = new GregorianCalendar();
        System.out.println("List created.");
        return records;
    }
}
