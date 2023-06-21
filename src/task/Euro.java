package task;

public class Euro {
    private int cents;

    public Euro() {
        this.cents = 0;
    }

    public Euro(int cents) {
        this.cents = cents;
    }

    public Euro(int euro, int cents) {
        this(100 * euro + cents);
    }

    public Euro(Euro euro) {
        this(euro.cents);
    }

    public int getCents() {
        return cents;
    }

    public void setCents(int cents) {
        this.cents = cents;
    }

    public Euro add(Euro euro) {
        cents += euro.cents;
        return this;
    }

    public Euro subtract(Euro euro) {
        cents -= euro.cents;
        return this;
    }

    public Euro multiply(int x) {
        cents *= x;
        return this;
    }

    public Euro multiply(double x) {
        cents = (int) (cents * x);
        return this;
    }

    @Override
    public String toString() {
        return String.format("%d.%02d", cents / 100, cents % 100);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Euro other = (Euro) obj;
        return cents == other.cents;
    }

    public int compareTo(Euro euro) {
        return Integer.compare(cents, euro.cents);
    }
}
