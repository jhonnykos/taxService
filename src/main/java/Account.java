public class Account {

    private int income;
    private int expenses;

    public Account(){
        this.income = 0;
        this.expenses = 0;
    }

    public void addIncome(int inc){
        if(inc < 0) {
            return;
        }
        this.income += inc;
    }

    public void addExpenses(int exp){
        if(exp < 0) {
            return;
        }
        this.expenses += exp;
    }

    public int getTotalIncome(){
        return income;
    }

    public int getTotalExpenses(){
        return expenses;
    }

    public int getTax6p(){
        return income * 6 / 100;
    }

    public int getTax15p() {
        if (income > expenses) {
            return (income - expenses) * 15 / 100;
        } else {
            return 0;
        }
    }


}
