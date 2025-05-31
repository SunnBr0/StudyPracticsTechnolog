public class Secruty {
    String name = "Петров";

    public  Secruty(){

    } 
    public boolean acces(String student){
        if(student == "Петров"){
            return true;
        }else{
            return false;
        }
    }
}
