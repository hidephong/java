import java.util.*;
class bankMan {
    int count;
    bank[] accArr;
void bankMan(){
    accArr = new bank[100];
    count = 0;
    }

void displayAcc(){
    
    if(count < accArr.length){
        System.out.println("There are " + count + " account !");
    }else{
        System.out.println("ACCOUNT SUMMARY");
        for(count = 0; count < accArr.length; count++){
        System.out.println(accArr[count].getAccNumber() + "\t" + accArr[count].getAccName() + "\t" + accArr[count].getAccBalance());
        }
    }
}

void creatAcc(){
    bank acc = new bank();
    if(count < accArr.length){
    Scanner in = new Scanner(System.in);
    System.out.println("Input AccNumber");
        int accNum = Integer.parseInt(in.nextLine());
        acc.setAccNumber(accNum);
    System.out.println("Input AccName:");
        String accNam = in.nextLine();
        acc.setAccName(accNam);
    System.out.println("Input AccBalance:");
        float accBal = Float.parseFloat(in.nextLine());
        while(accBal < 100){
            System.out.println("Minimun Balance is 100$");
            break;
        }
        acc.setAccBalance(accBal);

    accArr[count] = acc;
    count++;
    }else{
        System.out.println("Thu vien da day !");
    }
}


}
