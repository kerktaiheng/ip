public class Alice {
    public static void main(String[] args) {
        String logo = 
            "   ,---,        ,--,                                 \n" +
            "  '  .' \\     ,--.'|     ,--,                        \n" +
            " /  ;    '.   |  | :   ,--.'|                        \n" +
            ":  :       \\  :  : '   |  |,                         \n" +
            ":  |   /\\   \\ |  ' |   `--'_       ,---.     ,---.   \n" +
            "|  :  ' ;.   :'  | |   ,' ,'|     /     \\   /     \\  \n" +
            "|  |  ;/  \\   \\  | :   '  | |    /    / '  /    /  | \n" +
            "'  :  | \\  \\ ,'  : |__ |  | :   .    ' /  .    ' / | \n" +
            "|  |  '  '--' |  | '.'|'  : |__ '   ; :__ '   ;   /| \n" +
            "|  :  :       ;  :    ;|  | '.'|'   | '.'|'   |  / | \n" +
            "|  | ,'       |  ,   / ;  :    ;|   :    :|   :    | \n" +
            "`--''          ---`-'  |  ,   /  \\   \\  /  \\   \\  /  \n" +
            "                        ---`-'    `----'    `----'   \n";
        System.out.println("Hello from\n\n" + logo + "\n\n");
        System.out.println("What can I do for you today?\n\n");
        while (true) {
            String input = System.console().readLine();
            if (input.equals("bye")) {
                break;
            }
            System.out.println(input + "\n");
        }
        System.out.println("See you soon!");
    }
}
