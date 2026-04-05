public class Java13Examples {

    public static void main(String[] args) {
        Java13Examples je = new Java13Examples();
        je.textBlock();
    }

    private void textBlock() {
        String jsonBlock = """
                {
                  "key1" : 1,
                  "key2" : 2,
                  "key3  : " {
                             "key4" : "v4",
                             "key5" : ["k5v1", "k5v2"],
                             "key6" : "v6"
                             }
                }             
                
                """;
        System.out.println(jsonBlock);

        String queryBlock = """
                insert into 
                    table1(id, name)
                    values(?,?)  
                """;
        System.out.println(queryBlock);



    }
}
