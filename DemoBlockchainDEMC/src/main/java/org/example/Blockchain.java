package org.example;

import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class Blockchain {
    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    private static int difficulty = 5;

    public static void main(String[] args) {
       Block genesisblock = new Block("this is the first block","0");
       System.out.println("Hash for the first block is :" + genesisblock.hash);

       Block secondBlock = new Block("this is the second block", "1");
       System.out.println("Hash for the second block is :" + secondBlock.hash);

       Block thirdBlock =  new Block("this is the third block", "2");
       System.out.println("Hash for the third block is :" + thirdBlock.hash);

        blockchain.add(new  Block("Hi im the first block", "0"));
        blockchain.add(new Block("Yo im the second block",blockchain.get(blockchain.size()-1).hash));
        blockchain.add(new Block("Hey im the third block",blockchain.get(blockchain.size()-1).hash));

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);

    }
    public static Boolean isChainValid(){
        Block currentblock;
        Block previousblock;

        for(int i=1; i<blockchain.size(); i++) {
            currentblock = blockchain.get(i);
            previousblock = blockchain.get(i-1);
            if(!currentblock.hash.equals(currentblock.calculatehash())){
                System.out.println("Current Hashes Not Equal");
                return false;
            }
            if(!previousblock.hash.equals(currentblock.previousHash) ) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
        }
        return true;
    }
} // this method will check the integrity of the chain by comparing the hash of the current block with the
// hash calculated and will also check the hash of the previous block as well.
//any changes to the block's data will make this method return false, the longest valid chain is accepted.