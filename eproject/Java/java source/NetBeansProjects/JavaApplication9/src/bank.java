class bank {
    int accNumber;
    String accName;
    double accBalance;

    int getAccNumber() {
        return accNumber;
    }

    void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    String getAccName() {
        return accName;
    }

    void setAccName(String accName) {
        this.accName = accName;
    }

    double getAccBalance() {
        return accBalance;
    }

    void setAccBalance(float accBalance) {
        this.accBalance = accBalance;
    }

   public bank(){
        this.accNumber = 0;
        this.accName = "";
        this.accBalance = 0.0;
    }
   public bank(int accNum, String accNam, float accBal){
        setAccNumber(accNum);
        setAccName(accNam);
        setAccBalance(accBal);
    }





}
