public class Tests {
    public static void main (String [] args){
        if(test_put_and_get() && test_remove() && test_get_warmest() && test_300_circular_gets())
            System.out.println("all tests are good");
        else if (!test_put_and_get())
            System.out.println("fails test_put_and_get");
        else if (!test_remove())
            System.out.println("fails test_remove");
        else if (!test_get_warmest())
            System.out.println("failed test_get_earmest");
        else
            System.out.println("failed test_300_circular_gets");
    }

    public static boolean test_put_and_get(){
        Warmest<Integer,String> warmest = new Warmest<>();
        warmest.put(1,"1");
        boolean bol1= warmest.getWarmest().equals("1");
        warmest.put(2,"2");
        boolean bol2= warmest.getWarmest().equals("2");
        boolean bol3= warmest.get(1).equals("1");
        boolean bol4 = warmest.getWarmest().equals("1");
        boolean bol5= warmest.get(3)==null;
        return bol1 && bol2 && bol3 && bol4 && bol5;
    }
    public static boolean test_remove(){
        Warmest<Integer,String> warmest = new Warmest<>();
        warmest.put(1,"1");
        warmest.put(2,"2");
        warmest.put(3,"3");
        warmest.remove(2);
        boolean bol1=warmest.getWarmest().equals("3");
        boolean bol2= warmest.remove(3).equals("3");
        boolean bol3=warmest.getWarmest().equals("1");
        boolean bol4= warmest.remove(1).equals("1");
        boolean bol5= warmest.getWarmest()==null;
        boolean bol6= warmest.remove(4)==null;
        return bol1 && bol2 && bol3 && bol4 && bol5 && bol6;
    }
    public static boolean test_get_warmest(){
        Warmest<Integer,String> warmest = new Warmest<>();
        warmest.put(1,"hello");
        boolean bol1= warmest.getWarmest().equals("hello");
        warmest.put(2, "warmest");
        boolean bol2= warmest.getWarmest().equals("warmest");
        warmest.get(1);
        boolean bol3= warmest.getWarmest().equals("hello");
        warmest.remove(1); //remove hello
        boolean bol4= warmest.getWarmest().equals("warmest");
        warmest.remove(2);
        boolean bol5= warmest.getWarmest()==null;
        return bol1 && bol2 && bol3 && bol4 && bol5;
    }
    public static boolean test_300_circular_gets(){
        Warmest<Integer,String> warmest = new Warmest<>();
        warmest.put(1,"1");
        warmest.put(2, "2");
        warmest.put(3, "3");
        for (int i=0; i<100; i++){
            warmest.get(1);
            warmest.get(2);
            warmest.get(3);
        }
        boolean bol1= warmest.getWarmest().equals("3");
        warmest.remove(2);
        boolean bol2= warmest.getWarmest().equals("3");//3
        warmest.remove(3);
        boolean bol3= warmest.getWarmest().equals("1");
        warmest.remove(1);
        boolean bol4=warmest.getWarmest()==null;
        boolean bol5= warmest.getWarmList()=="";
        return bol1 && bol2 && bol3 && bol4 && bol5;


    }
}
