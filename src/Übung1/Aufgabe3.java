package Übung1;

public class Aufgabe3 {

    public Aufgabe3(){
        System.out.println(addAscii("34561".toCharArray(), "0xACDC".toCharArray()));

    }

    public static void main(String[] args) {
        Aufgabe3 v = new Aufgabe3();
    }

    int addAscii(char[] a, char[] b){
        return getInteger(a) + getInteger(b);
    }

    int getInteger(char[] a){

        StringBuilder s = new StringBuilder();
        for (int i = 2; i < a.length; i++){
            s.append(a[i]);
        }

        String number = s.toString();

        //Binär
        if(a.length >= 2 && a[1] == 'b'){
            return binaer(number);
        }
        //Hexa
        else if(a.length >= 2 && a[1] == 'x'){
            return binaer(HexToBin(number));
        }
        //Dezimal
        else{
            s.delete(0, s.length());

            for (char c : a) {
                s.append(c);
            }

            return parse(s.toString());
        }
    }

    public String HexToBin(String s){
        StringBuilder builder = new StringBuilder();

        for(String str : changetoarray(s)){
            switch(str){
                case "0" -> {
                    builder.append("0000");
                }

                case "1" -> {
                    builder.append("0001");
                }

                case "2" -> {
                    builder.append("0010");
                }

                case "3" -> {
                    builder.append("0011");
                }

                case "4" -> {
                    builder.append("0100");
                }

                case "5" -> {
                    builder.append("0101");
                }
                case "6" -> {
                    builder.append("0110");
                }

                case "7" -> {
                    builder.append("0111");
                }

                case "8" -> {
                    builder.append("1000");
                }

                case "9" -> {
                    builder.append("1001");
                }

                case "A" -> {
                    builder.append("1010");
                }

                case "B" -> {
                    builder.append("1011");
                }

                case "C" -> {
                    builder.append("1100");
                }

                case "D" -> {
                    builder.append("1101");
                }

                case "E" -> {
                    builder.append("1110");
                }

                case "F" -> {
                    builder.append("1111");
                }
            }
        }
        return builder.toString();
    }

    public int binaer(String s){

        String[] a = changetoarray(s);
        int n_length = a.length - 1;

        int sum = 0;

        for(int i = 0; i < a.length; i++){
            if(a[i].equals("1")){
                sum += Math.pow(2, n_length - i);
            }
        }

        return sum;
    }

    public String[] changetoarray(String s){
        String[] str = new String[s.length()];

        for(int i = 0; i < str.length; i++){
            str[i] = s.substring(i, i + 1);
        }

        return str;
    }

    public int parse(String s){

        int sum = 0;

        String[] arr = changetoarray(s);

        int z = arr.length - 1;

        for(int i = 0; i < arr.length; i++){

            switch(arr[i]){
                case "0" ->{
                    //egal
                }
                case "1" ->{
                    sum += 1 * Math.pow(10, z);
                }
                case "2" ->{
                    sum += 2 * Math.pow(10, z);
                }
                case "3" ->{
                    sum += 3 * Math.pow(10, z);
                }
                case "4" ->{
                    sum += 4 * Math.pow(10, z);
                }
                case "5" ->{
                    sum += 5 * Math.pow(10, z);
                }
                case "6" ->{
                    sum += 6 * Math.pow(10, z);
                }
                case "7" ->{
                    sum += 7 * Math.pow(10, z);
                }
                case "8" ->{
                    sum += 8 * Math.pow(10, z);
                }
                case "9" ->{
                    sum += 9 * Math.pow(10, z);
                }
            }

            z--;
        }

        return sum;
    }
}
