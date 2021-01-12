package doctor;

import java.util.ArrayList;

public class WaitingList {

    private ArrayList<String> waitingList = new ArrayList<String>();

    //**********************Add Patient to waiting list***************
     public void bookPatient(String patient){
        waitingList.add(patient);
     }

     public void printWaitingList(){
         System.out.println("There is currently " + waitingList.size() + "people in the queue");
         for (int i=0; i<waitingList.size();i++){
             System.out.println((i+1) + "." + waitingList.get(i));
         }


        }


    //******************OverLoaded Method******************
    //Check to see if current Item is in the list, if it is , ask for the Item they'd like to replace it with.
    public void modifyItem(String currentPatient, String newPatient){
        int position = findItem(currentPatient);
        if(position >= 0){
            modifyItem(position, newPatient);
        }
    }
    private void modifyItem(int position, String newPatient){
        waitingList.set(position,newPatient);
        System.out.println("Patient" + (position +1) + "Has been modified");
    }




    public void removePatient(String patient){
        int position = findItem(patient);
        if(position >= 0) {
            removeItem(position);
        }
        else {
            System.out.println("Patient not found.");
        }
    }

    private void removeItem(int position){
        waitingList.remove(position);
    }


    public int findItem(String searchPatient) {
        return waitingList.indexOf(searchPatient);
    }
    public boolean onSystem(String searchPatient){
        int position = findItem(searchPatient);
        if(position >= 0) {
            return true;
        }
        return false;
    }



}
