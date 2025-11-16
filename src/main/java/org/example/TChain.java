package org.example;

import java.util.ArrayList;
import com.google.gson.gsonBuilder;

public class TChain {
    public static ArrayList<Block> blockchain = new ArrayList<Block>();

    public static Boolean isChainValid() {
        Block currentBlock; //set current
        Block previousBlock;

        for(int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get( i - 1);

            //compare registered hash and calculated hash
            if(!previousBlock.hash.equals(currentBlock.calculateHash()) ) {
                System.out.println("current hashes not equal");
                return false;
            }

            //compare previous hash and registered previous hash
            if(!previousBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("previous hashes not equal");
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        blockchain.add(new Block("Hi im the first block", "0"));
        blockchain.add(new Block("Hi im the second block", blockchain.get(blockchain.size() - 1).hash));
        blockchain.add(new Block("Hi im the third block", blockchain.get(blockchain.size() - 2).hash));

        String blockchainJSON = new GsonBuilders.setPrettyPrinting().create().toJSON(blockchain);
        System.out.println(blockchainJSON);
    }


}
