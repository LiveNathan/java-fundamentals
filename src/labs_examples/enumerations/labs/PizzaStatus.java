package labs_examples.enumerations.labs;

enum PizzaStatus {
    ORDERED, MAKING, READY, DELIVERED;
}

class Pizza {
    private PizzaStatus status;

    public boolean isDeliverable() {
        return status == PizzaStatus.READY;
    }

    public void setStatus(PizzaStatus status) {
        this.status = status;
    }

    public PizzaStatus getStatus() {
        return this.status;
    }
}