package com.company;
public class listaenlazada {
    public nodo First, Last;
    public int tamaño;
    public  listaenlazada()
    {
        this.First = null;
        this.Last = null;
        this.tamaño = 0;
    }
    public void agrega(Object valor)//Metodo agregar
    {
        nodo mnodo = new nodo(valor);
        if (this.tamaño==0)
            this.First = mnodo;
        else
        {
            nodo ahora = this.First;
            while (ahora.Next != null)
                ahora = ahora.Next;
            ahora.Next = mnodo;
            ahora.Next.Prev = ahora;
        }
        this.tamaño += 1;
    }

    public nodo popFirst()
    {
        if(this.tamaño ==1) {
            nodo k = this.First;
            this.First = null;

            this.tamaño = 0;
            return k;
        }
        else
        if (this.tamaño != 0)
        {
            nodo a = this.First;
            this.First = a.Next;
            this.tamaño -= 1;
            return a;
        }
        else return null;

    }

    @Override
    public String toString() {//impresion de resultados
        String retorno="";
        int cont = 0;
        nodo m = this.First;
        while (m!= null)
        {
            retorno+="\n "+cont+": "+m;
            m=m.Next;
            cont++;
        }

        return "listaenlazada{" +
                retorno+
                "\n}";
    }
}
