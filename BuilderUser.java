import java.math.BigInteger;
import java.util.Random;
public class BuilderUser {
    private String login;
    private String password;
    private BigInteger cardnumberEU;
    private BigInteger cardnumberUSA;
    private BigInteger cardnumberUA;

    private BuilderUser(Builder builder) {
        this.login = builder.login;
        this.password = builder.password;
        this.cardnumberEU = builder.cardnumberEU;
        this.cardnumberUSA = builder.cardnumberUSA;
        this.cardnumberUA = builder.cardnumberUA;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public BigInteger getCardnumberEU() {
        return cardnumberEU;
    }

    public BigInteger getCardnumberUSA() {
        return cardnumberEU;
    }

    public BigInteger getCardnumberUA() {
        return cardnumberEU;
    }

    public static class Builder {
        private String login;
        private String password;
        private BigInteger cardnumberEU;
        private BigInteger cardnumberUSA;
        private BigInteger cardnumberUA;

        public Builder(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public Builder cardnumberEU(BigInteger cardnumberEU) {
            this.cardnumberEU = cardnumberEU;
            return this;
        }

        public Builder cardnumberUSA(BigInteger cardnumberUSA) {
            this.cardnumberUSA = cardnumberUSA;
            return this;
        }

        public Builder cardnumberUA(BigInteger cardnumberUA) {
            this.cardnumberUA = cardnumberUA;
            return this;
        }

        public BuilderUser build() {
            return new BuilderUser(this);
        }
    }
}
