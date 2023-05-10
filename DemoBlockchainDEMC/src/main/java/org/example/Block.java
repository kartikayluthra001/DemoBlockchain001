package org.example;
import java.util.Date;
public class Block {
    public String hash; // holds our digital sig
    public String previousHash;
    private String data;
    private long Timestamp;
    private int n;
    public Block(){

    }
    public Block(String data, String previousHash){
        this.data = data;
        this.previousHash = previousHash;
        this.Timestamp = new Date().getTime();
    }

    public String getData() {
        return data;
    }
    public long getTimestamp(){
        return Timestamp;
    }
    public String calculatehash(){
        String calculatedhash= StringUtil.applySha256(previousHash +
                Long.toString(getTimestamp()) +getData());
        return calculatedhash;
    }

    public void mineBlock(int difficulty){ // method to mine blocks with proof-of-work stake with an
        //original difficulty of 4-6 atleast
        String target = new String(new char[difficulty]).replace('\0','0');
        while(!hash.substring( 0, difficulty).equals(target)){
            n++;
            hash = calculatehash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }
}
