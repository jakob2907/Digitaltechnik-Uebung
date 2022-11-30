package Übung1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Aufgabe2 {

    public static void main(String[] args) {
        System.out.println(divFP(1649, 465));

    }

    public static int divFP(int a, int b){


        int z = 0;
        int vK = 0;
        while(z < a - b){
            z += b;
            vK++;
        }

        int nK = (a - z)*1000 / b;

        System.out.println("vK-Var: " + vK);
        System.out.println("nK-Var: " + nK);

        int[] arr_vK = toArray(vK);

        //wenn weniger als 2 Nachkommastellen -> Auffüllen

        int[] arr_nK = new int[2];
        int[] arr_T = toArray(nK);

        //------------------Funktioniert ^^^^

        if(toArray(nK).length <= 2){        //toArray(nK) == arr_T.length

            arr_nK[0] = -1;
            arr_nK[1] = -1;


            for(int i = 0; i < arr_T.length; i++){
                arr_nK[i] = arr_T[i];
            }

            for(int i = 0; i < arr_nK.length; i++){
                if(arr_nK[i] == -1){
                    arr_nK[i] = 0;
                }
            }
        }
        else
        {
            //länger als 3 Nachkommastellen -> Runden

            //Wenn dritte Zahl >= 5 -> Solange on hinten durch array solange die Zahlen im Array 9 sind, und diese dann durch 0 ersetzen
            //Sonst einfach arr_T in arr_nK kopieren

            if(arr_T[2] >= 5){
                //Runden
                System.out.println("Case Runden:");
                arr_T[1] ++;

                //Stelle gleich 9 -> Stelle gleich 0 + vorherige + 1

                if(arr_T[1] == 10){
                    //Umshiften

                    System.out.println("Case Umshiften");

                    arr_nK[1] = 0;
                    arr_T[0]++;

                    if(arr_T[0] == 10){
                        arr_nK[0] = 0;
                        arr_vK = roundVk(arr_vK);
                    }
                }
                else
                {
                    arr_nK[0] = arr_T[0];
                    arr_nK[1] = arr_T[1];
                }

            }
            else
            {
                //Nicht Runden
                arr_nK[0] = arr_T[0];
                arr_nK[1] = arr_T[1];
            }
        }

        System.out.println("nK" + Arrays.toString(arr_nK));

        //_____________________________________________

        int c= 0;
        int arr3[] = new int[arr_nK.length + arr_vK.length];
        for(int i = 0; i < arr_vK.length; i++){
            arr3[i] = arr_vK[i];
            c++;
        }
        for(int i = 0; i < 2; i++){
            arr3[c] = arr_nK[i];
            c++;
        }


        System.out.println(Arrays.toString(arr3));

        return arrtoint(arr3);
    }

    private static int[] toArray(int a){
        List<Integer> digits = new ArrayList<>();

        if(a == 0){
            return new int[]{0};
        }

        int num = a;

        for (; num != 0; num /= 10)
            digits.add(num % 10);

        int[] arr = new int[digits.size()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = digits.get(i);
        }

        // Umdrehen
         int[] arr2 = new int[arr.length];
        int z =0;
        for(int i = arr.length -1; i >= 0 ; i--){
            arr2[z] = arr[i];
            z++;
        }

        return arr2;
    }

    public static int[] roundVk(int[] vK){

        vK[vK.length - 1] ++;

        for(int i = vK.length - 1; i >= 0; i--){
            if(vK[i] == 10 && i >= 1){
                vK[i-1] ++;
                vK[i] = 0;
            }
            else if(vK[i] == 10){
                //vorderset Stelle gleich 9 -> Bsp 999999,99
                //-> neues Array mit einem Feld größer und nur einer einzigen 1 an erster Stelle

                int[] arr = new int[vK.length + 1];
                arr[0] = 1;

                return arr;

            }
            else
            {
                return vK;
            }
        }

        return vK;
    }

    public static int arrtoint(int[] arr){
        int sum = 0;

        int z = arr.length -1;

        for(int i = 0; i < arr.length; i++){

            sum += arr[i] * Math.pow(10, z);

            z--;
        }

        return sum;
    }

}
