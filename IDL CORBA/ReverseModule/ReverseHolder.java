package ReverseModule;

/**
* ReverseModule/ReverseHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ReverseModule.idl
* Friday, 6 May, 2022 12:57:53 PM IST
*/

public final class ReverseHolder implements org.omg.CORBA.portable.Streamable
{
  public ReverseModule.Reverse value = null;

  public ReverseHolder ()
  {
  }

  public ReverseHolder (ReverseModule.Reverse initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ReverseModule.ReverseHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ReverseModule.ReverseHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ReverseModule.ReverseHelper.type ();
  }

}
