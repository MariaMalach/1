package com.example.taskmanager.podroz;

public class ogol {
    private Kraj kraj;
    private Miasto miasto;
    
    public ogol(Kraj kraj){
        this.kraj = kraj;
    }
    
    public ogol(Miasto miasto){
        this.miasto = miasto;
    }
    
    public Kraj getKraj(){
        return kraj;
    }
    
    public void setKraj(Kraj kraj) {
        this.kraj = kraj;
    }
    
    public Miasto getMiasto(){
        return miasto;
    }
    
    public void setMiasto(Miasto miasto) {
        this.miasto = miasto;
    }
}
