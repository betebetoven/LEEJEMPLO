package com.company;

public class nodo {

    public   Object value;
    public   nodo izq, der,uniq,Next,Prev;
    public String propiedad;
    public nodo(Object value){
        this.value = value;
        this.izq = null;
        this.der = null;
        this.uniq = null;
        this.Next = null;
        this.Prev = null;
        this.propiedad = "";


    }
    public void  agregaderecha(Object valor)
    {
        nodo mnodo = new nodo(valor);
        if(this.der==null)
            this.der=mnodo;
            this.der.Prev = this;

    }
    public void  agregaizquierda(Object valor)
    {
        nodo mnodo = new nodo(valor);
        if(this.izq==null)
            this.izq=mnodo;
            this.izq.Prev = this;

    }
    public void  agregauniq(Object valor)
    {
        nodo mnodo = new nodo(valor);
        if(this.uniq==null)
            this.uniq=mnodo;
            this.uniq.Prev = this;

    }

    @Override
    public String toString() {
        if(this.izq == null && this.der== null && this.uniq == null && this.Next==null)
            return ""+this.hashCode()+ "[label=\"" +
                    this.value.getClass().cast(this.value)+
                    "\"]";
        else
            return ""+this.hashCode()+ "[label=\"" +
                    this.value.getClass().cast(this.value)+
                    "\"]";

    }

}