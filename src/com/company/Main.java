package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static listaenlazada original = new listaenlazada();
    public static listaenlazada copia = new listaenlazada();
    public static ArrayList<String> rawlist = new ArrayList<>();
    public static ArrayList<String> r ;
    public static listaenlazada p2 = new listaenlazada();
    public static listaenlazada rbol = new listaenlazada();
    public static ArrayList<nodo> hojas = new ArrayList<>() ;


    public static void rec()
    {
        for (int i = 0; i < r.size(); i++) {
            if (r.get(i).equals("+") ||  r.get(i).equals("*") || r.get(i).equals("?"))
            {
                String str = r.get(i-1);
                r.set(i-1,"("+str+r.get(i)+")");
                r.remove(i);
                rec();
                break;
            }
            else if (r.get(i).equals("|")) {
                String str = r.get(i-2);
                r.set(i-2,"("+str+r.get(i)+r.get(i-1)+")");
                r.remove(i);
                r.remove(i-1);
                rec();
                break;
            }
            else if (r.get(i).equals(".")) {
                String str = r.get(i-2);
                r.set(i-2,"("+r.get(i-1)+str+")");
                r.remove(i);
                r.remove(i-1);
                rec();
                break;


            }


        }

    }

    public static void hacearbol(listaenlazada pl, listaenlazada arbol)
    {
        nodo primero = new nodo(".");
        arbol.First = primero;//es el first y ahora agregar a la derecha
        arbol.First.agregaderecha("#");
        hojas.add(arbol.First.der);


            while (pl.First != null)
            {

                nodo ahoraizq;
                nodo ahorader;
                nodo ahora = pl.First;

                while (ahora != null)
                {

                    String j = (String) pl.popFirst().value;
                    ahoraizq = arbol.First;
                    while (ahoraizq.izq != null || ((String)ahoraizq.value).equals("|"))
                        ahoraizq = ahoraizq.izq;
                    if (((String)ahoraizq.value).equals("."))
                    {
                        if(j.equals(")"))//CAMBIAR LOS UNIQ A DER Y VER QUE LOS ) ESTEN BIEN VALIDADOS VOLVER A SEGUIR EL ALGORITMO PASO A PASO CON LA TABLA
                        {
                            String pa = (String) pl.popFirst().value;
                            String conec = (String) pl.popFirst().value;
                            String sa = (String) pl.popFirst().value;
                            pl.popFirst();
                            ahoraizq.agregaizquierda(conec);
                            ahoraizq = ahoraizq.izq;
                            ahoraizq.agregaizquierda(pa);
                            ahoraizq.agregaderecha(sa);
                            hojas.add(ahoraizq.der);//AGREGA A HOJAS ARRAY
                            hojas.add(ahoraizq.izq);//AGREGA A HOJAS ARRAY

                        }
                        else
                        {
                            ahoraizq.agregaizquierda(j);
                            ahoraizq = ahoraizq.izq;
                            if((j.equals("*")||j.equals("+")||j.equals("?") )&& pl.First!=null)
                            {
                                j = (String) pl.popFirst().value;
                                if(j.equals(")"))
                                {
                                    String pa = (String) pl.popFirst().value;
                                    String conec = (String) pl.popFirst().value;
                                    String sa = (String) pl.popFirst().value;
                                    pl.popFirst();
                                    ahoraizq.agregaderecha(conec);
                                    ahoraizq = ahoraizq.der;
                                    ahoraizq.agregaizquierda(pa);
                                    ahoraizq.agregaderecha(sa);
                                    hojas.add(ahoraizq.der);//AGREGA A HOJAS ARRAY
                                    hojas.add(ahoraizq.izq);//AGREGA A HOJAS ARRAY

                                }
                                else
                                {
                                    ahoraizq.agregaderecha(j);
                                    hojas.add(ahoraizq.der);///agrega a hojas array
                                }




                            }


                        }
                    }
                    else
                    {
                        nodo reemplazo = ahoraizq;
                        ahoraizq.Prev.izq = null;

                        nodo ahorizaiz = arbol.First;
                        while (ahorizaiz.izq != null || ((String)ahorizaiz.value).equals("|"))
                            ahorizaiz = ahorizaiz.izq;
                        ahorizaiz.agregaizquierda(".");
                        ahorizaiz = ahorizaiz.izq;
                        ahorizaiz.der = reemplazo;
                        if (!((String)ahorizaiz.der.value).equals("*")||!((String)ahorizaiz.der.value).equals("+")||!((String)ahorizaiz.der.value).equals("?")||!((String)ahorizaiz.der.value).equals("|"))
                            hojas.add(ahorizaiz.der);
                        if(j.equals(")"))
                        {
                            String pa = (String) pl.popFirst().value;
                            String conec = (String) pl.popFirst().value;
                            String sa = (String) pl.popFirst().value;
                            pl.popFirst();
                            ahorizaiz.agregaizquierda(conec);
                            ahorizaiz = ahoraizq.izq;
                            ahorizaiz.agregaizquierda(pa);
                            ahorizaiz.agregaderecha(sa);
                            hojas.add(ahorizaiz.der);//AGREGA A HOJAS ARRAY
                            hojas.add(ahorizaiz.izq);//AGREGA A HOJAS ARRAY

                        }
                        else
                        {
                            ahorizaiz.agregaizquierda(j);
                            if (!(j.equals("*"))||!(j.equals("+"))||!(j.equals("?")) )
                                        hojas.add(ahorizaiz.izq);///agrega a hojas array
                        }
                        ahorizaiz = ahorizaiz.izq;
                        if((j.equals("*")||j.equals("+")||j.equals("?") )&& pl.First!=null)
                        {
                            j = (String) pl.popFirst().value;
                            if(j.equals(")"))
                            {
                                String pa = (String) pl.popFirst().value;
                                String conec = (String) pl.popFirst().value;
                                String sa = (String) pl.popFirst().value;
                                pl.popFirst();
                                ahorizaiz.agregaderecha(conec);
                                ahorizaiz = ahorizaiz.der;
                                ahorizaiz.agregaizquierda(pa);
                                ahorizaiz.agregaderecha(sa);
                                hojas.add(ahorizaiz.der);//AGREGA A HOJAS ARRAY
                                hojas.add(ahorizaiz.izq);//AGREGA A HOJAS ARRAY

                            }
                            else
                            {
                                ahorizaiz.agregaderecha(j);
                                    hojas.add(ahorizaiz.der);///agrega a hojas array
                            }




                        }

                    }

                    ahora = pl.First;
                }

                //AHORA HACERLO GRAFICO


            }





    }

    public static String texto;
    public static void imprime_arbol(nodo root)
    {
        texto+=root+"\n";
        System.out.println("------------");
        System.out.println(root+":");
        System.out.println("R:"+root.der);
        System.out.println("L:"+root.izq);
        if (root.izq!=null) {
            texto+=root.hashCode()+"->"+root.izq.hashCode()+";\n";
            imprime_arbol(root.izq);
        }
        if (root.der!=null) {
            texto+=root.hashCode()+"->"+root.der.hashCode()+";\n";
            imprime_arbol(root.der);
        }
    }
    public static void imprime_completo()
    {
        texto = "digraph G\n"
                +"{label=\"expresion regular\"\n"
                +"        node[shape = circle]\n"
                +"        node[style = filled]\n"
                +"        node[fillcolor = \"#EEEEE\"]\n"
                +"        node[color = \"#EEEEE\"]\n"
                +"        node[color = \"#31CEF0\"]\n";

        imprime_arbol(rbol.First);

        texto+="\n"
                +"}";
        System.out.println(texto);
        texto = "";

    }


    public static void main(String[] args) {

        ArrayList<String> p = new ArrayList<>();

        p.add("b");
        p.add("{letrac}");
        p.add("{impar}");
        p.add("|");
        p.add("*");
        p.add("a");
        p.add(".");
        p.add(".");
        p.clear();

        p.add("d");
        p.add("+");
        p.add(";");
        p.add("d");
        p.add("+");

        String err = "";
        for (String n:p)
            err+=n;

        Collections.reverse(p);


        //"a"({letrac}|{impar})*"b"
        for (String n:p)
            p2.agrega(n);
        System.out.println(p2);
        System.out.println((String)p2.First.value );
        hacearbol(p2,rbol);
        imprime_completo();
        System.out.println(hojas);








    }

}
