import ew_snmp.SNMPApi;

import org.json.JSONObject;

class HelloJava {
    public  static void  printArray(Object[] array)
    {
        for (int i = 0; i < array.length; i++)
            {
                System.out.println("array:" + array[i]);
            }


    }


    public static void main(String[] args) {
        try{
         System.out.println("Hello from Java!"+ new JSONObject().put("JSON", "Hello, World!").toString());
         System.out.println("v2JSON: "+SNMPApi.v2Json ("localhost", "public", "1.3.6.1.2.1.1.5.0"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("v2: "+SNMPApi.v2 ("localhost", "public", "1.3.6.1.2.1.1.5.0"));
        System.out.println("v2all:");
        HelloJava.printArray(SNMPApi.v2all ("localhost", "public", "1.3.6.1.2.1.1.5.0"));
        System.out.println("v2allb:");
        HelloJava.printArray(SNMPApi.v2allb ("localhost", "public", new String[] {"1.3.6.1.2.1.1.5.0", "1.3.6.1.2.1.1.6.0"}));


        System.out.println("v3: "+SNMPApi.v3 ("localhost", "juanv3", "comomolalagramola", "1.3.6.1.2.1.1.5.0"));
        System.out.println("v3all:");
        HelloJava.printArray(SNMPApi.v3all ("localhost","juanv3", "comomolalagramola", "1.3.6.1.2.1.1.5.0"));

        System.out.println("v3allb:");
        HelloJava.printArray(SNMPApi.v3allb ("localhost","juanv3", "comomolalagramola", new String[] {"1.3.6.1.2.1.1.5.0", "1.3.6.1.2.1.1.6.0"}));


        System.out.println("ERROR HOST: return java.lang.NullPointerException:  "+SNMPApi.v2 ("error-host", "public", "1.3.6.1.2.1.1.5.0"));

        System.out.println("ERROR community name return java.lang.NullPointerException:  "+SNMPApi.v2 ("localhost", "error-community", "1.3.6.1.2.1.1.5.0"));
    }
}
