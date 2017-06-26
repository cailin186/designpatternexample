package com.javapatterns.prototype.monkeyking2;

import java.util.Date;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.OptionalDataException;
import java.io.Serializable;

public class Monkey implements Cloneable, Serializable
{
    public Monkey()
    {
    	this.birthDate = new Date();
        this.staff = new GoldRingedStaff();
    }
	public Object deepClone()
        throws IOException, OptionalDataException, ClassNotFoundException
	{
	    //write to stream
	    ByteArrayOutputStream bo = new ByteArrayOutputStream();
	    ObjectOutputStream oo = new ObjectOutputStream(bo);
	    oo.writeObject(this);
	
	    //read from stream
	    ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
	    ObjectInputStream oi = new ObjectInputStream(bi);
	
	    return (oi.readObject());
	}

    public Object clone()
    {
        Monkey temp = null;
        try
        {
            temp = (Monkey) super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            System.out.println("Clone failed");
        }
        finally
        {
            return temp;
        }
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    public Date getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }

    public GoldRingedStaff getStaff()
    {
        return staff;
    }

    private int height;
    private int weight;

    /**
     * @directed
     * @clientCardinality 1
     * @supplierCardinality 1
     */
    private GoldRingedStaff staff;
    private Date birthDate;
}
