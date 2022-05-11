package ManegeCandidate;

import File.CandidateFile;
import Normal.Candidate;

import java.io.FileNotFoundException;
import java.util.*;

public class ManegeCandidate {
    private CandidateFile candidateFile;
    List<Candidate>candidateList=new ArrayList<>();


    public ManegeCandidate(List<Candidate> candidateList) {
        this.candidateList = candidateList;
    }

    public ManegeCandidate() throws FileNotFoundException {
        candidateList= CandidateFile.readFromFile();
    }

    public List<Candidate> getCandidateList() {
        return candidateList;
    }

    public void setCandidateList(List<Candidate> candidateList) {
        this.candidateList = candidateList;
    }

    public void add(Candidate candidate) throws FileNotFoundException {
        this.candidateList.add(candidate);
        CandidateFile.writeToFile(candidateList);
    }
    public void display(){
        for (int i = 0; i < candidateList.size(); i++) {
            System.out.println(candidateList.get(i));
        }
    }
    public int seachById(int idNumber){
        for (int i = 0; i < candidateList.size(); i++) {
            if(this.candidateList.get(i).getIdNumber()==idNumber){
                System.out.println(candidateList.get(i));
                return i;
            }
        }
        return -1;
    }
    public void delete(int idNumber){
        int indexOfId=seachById(idNumber);
        if(indexOfId==-1){
            System.out.println("KHÔNG CÓ THÍ SINH NÀY ĐÂU MÀ TÌM!!");
        }
        else {
            this.candidateList.remove(indexOfId);
        }
    }
    public void edit(int idNumber,Candidate candidate){
        int indexOfId=seachById(idNumber);
        if(indexOfId==-1){
            System.out.println("KHÔNG CÓ THÍ SINH NÀY ĐÂU MÀ TÌM!!");
        }
        else {
            this.candidateList.set(indexOfId,candidate);
        }
    }
    public void seachByBlock(String block){
        for (int i = 0; i < candidateList.size(); i++) {
            if(candidateList.get(i).getBlock().equals(block)){
                System.out.println(candidateList.get(i));
            }
        }
    }
    public void sortInId(){
        Collections.sort(this.candidateList, new Comparator<Candidate>() {
            @Override
            public int compare(Candidate candidate1, Candidate candidate2) {
                if (candidate1.getIdNumber() < candidate2.getIdNumber()) {
                    if (candidate1.getIdNumber() > candidate2.getIdNumber()) {
                        return -1;
                    } else {
                        return 0;
                    }
                } else {
                    return 1;
                }
            }
            });
    }
}
