class bank {
    int accNumber;
    String accName;
    float accBalance;

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

    float getAccBalance() {
        return accBalance;
    }

    void setAccBalance(float accBalance) {
        this.accBalance = accBalance;
    }

    bank(){
        this.accNumber = 0;
        this.accName = "";
        this.accBalance = 0;
    }
    void bank(int accNum, String accNam, float accBal){
        this.setAccNumber(accNum);
        this.setAccName(accNam);
        this.setAccBalance(accBal);
    }
}
