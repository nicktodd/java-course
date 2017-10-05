// Classes.java

class A
{
}

class B
{
   @Override
   public String toString()
   {
      return "B";
   }
}

class C
{
   public String toString(int x)
   {
      return "C "+x;
   }
}

@ToString
class D
{
}

class E
{
   
   @Override
   public String toString()
   {
      return "E";
   }
}

@ToString
class F
{
   public String toString(int x)
   {
      return "F "+x;
   }
}

@ToString
interface G
{
}
