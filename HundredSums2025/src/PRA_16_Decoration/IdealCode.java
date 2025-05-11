package PRA_16_Decoration;
//import java.io.*;
import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;

public class IdealCode {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        decser ds = new decser();
        int n = sc.nextInt();
        dec[] d = new dec[n];
        int did, quantavl, thresh;
        String type, dname, typef;
        double ppu;
        for(int i=0; i<n; i++){
            did = sc.nextInt();
            sc.nextLine();
            dname = sc.nextLine();
            type = sc.nextLine();
            quantavl = sc.nextInt();
            ppu = sc.nextDouble();
            d[i] = new dec(did, dname, type, quantavl, ppu);
            sc.nextLine();
        }
        typef = sc.nextLine();
        thresh = sc.nextInt();
        
        try {
            double ttl = ds.ttlstkval(d, typef);
            if(ttl>0){
                System.out.println("Total Stock Value: "+ ttl);
            }else{    
                throw new custexception("Type Not Found");  
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            ArrayList<String> l = ds.stkthresh(d, thresh);
            if(l.size() > 0){
                System.out.println("Decorations Below Stock Threshold:");
                for(String m: l){
                    System.out.println(m);
                }
            }else{
                
                throw new custexception("No Decorations Below Stock Threshold");
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}

class decser{
    decser(){}
    
    public double ttlstkval(dec[] d, String typef){
        double ttl = 0;
        for(int j=0; j<d.length; j++){
            if(typef.equalsIgnoreCase(d[j].getType())){
                ttl = d[j].getQuantavl() * d[j].getPpu(); 
            }
        }
        return ttl;
    }
    
    public ArrayList<String> stkthresh(dec[] d, int thresh){
        List<String> l = new ArrayList<>();
        for(int k=0; k<d.length; k++){
            if(d[k].getQuantavl() < thresh){
                l.add(d[k].getDname());
            }
        }
        return (ArrayList<String>) l;
    }
}

class custexception extends Exception{
    public custexception(String s){
        super(s);
    }
}

class dec{
    private int did;
    private String dname;
    private String type;
    private int quantavl;
    private double ppu;
    
    dec(int did, String dname, String type, int quantavl, double ppu){
        this.did = did;
        this.dname = dname;
        this.type = type;
        this.quantavl = quantavl;
        this.ppu = ppu;
    }
    
	public int getDid() {
		return did;
	}
	public String getDname() {
		return dname;
	}
	public String getType() {
		return type;
	}
	public int getQuantavl() {
		return quantavl;
	}
	public double getPpu() {
		return ppu;
	}    
}
    

