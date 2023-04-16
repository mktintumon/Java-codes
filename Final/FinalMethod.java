
// we can inherit final method class but cant override them

class Base{
    final void change(){
        System.out.println("My name is Mohit");
    }
}

class FinalMethod extends Base{
    /* 
        This will give compilation errors
        ----> cannot override final method

        void change(){
            System.out.println("My name is Kumar");
        }
    */

    public static void main(String[] args) {
        FinalMethod fm = new FinalMethod();
        fm.change();
    }
}
