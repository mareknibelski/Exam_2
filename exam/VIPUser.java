package exam;

import static java.sql.Types.NULL;

public class VIPUser extends User {

    private Integer vipCardNumber;
    private int newNumber;

    public VIPUser(String name, String lastName, String email, Integer vipCardNumber) {
        super(name, lastName, email);
        if (checkCard(newNumber) == true) {
            this.vipCardNumber = vipCardNumber;
        } else {
            this.vipCardNumber = NULL;
        }
    }

    private boolean checkCard(int newNumber) {
        if (newNumber > 999 && newNumber % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public VIPUser setVipCardNumber(int newCardNumber) {
        if (checkCard(newCardNumber)) {
            this.vipCardNumber = vipCardNumber;
        }
        return this;
    }

    public Integer getVipCardNumber() {
        return vipCardNumber;
    }

}
