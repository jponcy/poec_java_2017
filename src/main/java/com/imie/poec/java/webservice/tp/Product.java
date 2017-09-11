package com.imie.poec.java.webservice.tp;

public class Product implements Entity {
    private static Long idGenerator = 0l;

    private Long id = null;
    private String name;
    private String reference;
    private String description;
    private float price;

    /** To create new object. */
    public Product() {
    }

    /** For data initialize. */
    public Product(String name, String reference, String description, float price) {
        this.setName(name);
        this.setReference(reference);
        this.setDescription(description);
        this.setPrice(price);

        try {
            this.generateId();
        } catch (IdRegenException e) {
            e.printStackTrace();
            this.id = 42l;
        }
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.getReference(), this.getName());
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Generates then set the id if not null.
     * @throws IdRegenException If call this method about an entity with id.
     */
    public void generateId() throws IdRegenException {
        if (this.getId() == null) {
            this.id = ++idGenerator;
        } else {
            throw new IdRegenException();
        }
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * @param reference
     *            the reference to set
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price
     *            the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }
}
