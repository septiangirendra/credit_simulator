/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package credit_simulator;

//memasukan package
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 *
 * @author Septian Girendra
 */
public class Credit_simulator {

    private String getTanggal(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        
        Date date = new Date();
        
        return dateFormat.format(date);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Deklarasi Variabel
        String Kendaraan, Kondisi,tahun_loop;
        int Tahun, i=1;
        float Pinjam, Tenor, DP, Total, Bulan, Est_tahun,Est_bulanan_loop, Est_loop;
        float Rate_motor=0.09f, Rate_mobil=0.08f, Rate_tambah, Rate_conv;
        // Membuat scanner baru
        Scanner keyboard = new Scanner(System.in);
        Credit_simulator tgl = new Credit_simulator();
        tahun_loop = tgl.getTanggal();
        
        int number_tahun = Integer.valueOf(tahun_loop);

        
        System.out.print("Jenis Kendaraan Mobil|Motor :");
        Kendaraan = keyboard.nextLine();
        
        System.out.print("Kondisi Kendaraan Bekas|Baru :");
        Kondisi = keyboard.nextLine();
        
        System.out.print ("Tahun Kendaraan :");
        Tahun = keyboard.nextInt();
        if(Kondisi.equalsIgnoreCase("Baru")){
            if(Tahun>number_tahun){
                System.out.println("Tahun tidak boleh lebih dari tahun berjalan");
            }
        }
        
        System.out.print("Jumlah Pinjaman :");
        Pinjam = keyboard.nextInt();
        
        System.out.print("Jumlah Tenor dalam tahun:");
        Tenor = keyboard.nextInt();
        if(Tenor>6){
            System.out.println("Tenor tidak boleh lebih dari 6 Tahun");
        }
        
        System.out.print("Jumlah DP :");
        DP = keyboard.nextInt();
        
        if(Kondisi.equalsIgnoreCase("baru")){
            int NewDP = (int) (0.35f*Pinjam);
            if(DP>=NewDP){
                System.out.println("DP Tidak boleh lebih dari 35% dari Pinjaman ");
            }
        }else{
            int NewDP = (int) (0.25f*Pinjam);
            if(DP>=NewDP){
                System.out.println("DP Tidak boleh lebih dari 35% dari Pinjaman ");
            }
        }

        System.out.println("==========================================="); 
        
        if (Kendaraan.equalsIgnoreCase("motor")) {
        Total = (Pinjam*Rate_motor)+Pinjam;
        Bulan = Total/(12*Tenor);
        Est_tahun = Bulan*12;
        int number_motor = number_tahun+1;
        
        
        if(number_motor%2==0){
            Rate_tambah = Rate_motor + 0.005f;
            Rate_conv = Rate_tambah * 100;
            //System.out.println("Rate_tambah "+Rate_conv);
        }else{
            Rate_tambah = Rate_motor + 0.001f;
            Rate_conv = Rate_tambah * 100;
            //System.out.println("Rate_tambah "+Rate_conv);
        }
        System.out.println("Tahun Ke "+1+" Rp. "+Bulan+"/bln"+", Suku Bunga "+Rate_motor*100); 
        for(int x=2; x <=Tenor; x++){
            Est_loop = (Total-Est_tahun);
            float Est_loop1 = (Est_loop*Rate_conv)-Est_loop;
            Est_bulanan_loop = Est_loop1/(12*Tenor)-12;
            System.out.println("Tahun Ke "+x+" Rp. "+Est_bulanan_loop+"/bln"+", Suku Bunga "+Rate_conv); 
        }
        } else {
                Total = (Pinjam*Rate_mobil)+Pinjam;
                Bulan = Total/(12*Tenor);
                Est_tahun = Bulan*12;
                
                int number_motor = number_tahun+1;
        
        
                if(number_motor%2==0){
                    Rate_tambah = Rate_mobil + 0.005f;
                    Rate_conv = Rate_tambah * 100;
                    System.out.println("Rate_tambah "+Rate_conv);
                }else{
                    Rate_tambah = Rate_mobil + 0.001f;
                    Rate_conv = Rate_tambah * 100;
                    System.out.println("Rate_tambah "+Rate_conv);
                }
                    System.out.println("Tahun Ke "+1+" Rp. "+Bulan+"/bln"+", Suku Bunga "+Rate_mobil*100); 
                    for(int x=2; x <=Tenor; x++){
                    Est_loop = (Total-Est_tahun);
                    float Est_loop1 = (Est_loop*Rate_conv)-Est_loop;
                    Est_bulanan_loop = Est_loop1/(12*Tenor)-12;
                    System.out.println("Tahun Ke "+x+" Rp. "+Est_bulanan_loop+"/bln"+", Suku Bunga "+Rate_conv);
            }
        }
       
       } 
    }    
        