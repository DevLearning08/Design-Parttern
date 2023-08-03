package domain;


public class CommandProcessor {

    public void execute(HoadonService cmd){
        cmd.action();
    }
    
}
