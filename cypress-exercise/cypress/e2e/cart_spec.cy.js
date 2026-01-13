describe('Cart Test', () => {

    beforeEach(() => {
        cy.visit('https://www.saucedemo.com');
        cy.get('#user-name').type('standard_user');
        cy.get('#password').type('secret_sauce');
        cy.get('#login-button').click();

        // đảm bảo đã vào inventory
        cy.url().should('include', '/inventory.html');
    });

    it('Should add a product to the cart', () => {
        cy.get('.inventory_item').first()
            .find('button')
            .click();

        cy.get('.shopping_cart_badge').should('have.text', '1');
    });

    it('Should remove product from cart', () => {
        cy.get('.inventory_item').first()
            .find('button')
            .click();

        cy.get('.shopping_cart_link').click();

        cy.get('.cart_item')
            .find('.cart_button')
            .click();

        cy.get('.shopping_cart_badge').should('not.exist');
    });

    it('Should sort products by price low to high', () => {
        cy.get('.product_sort_container').select('lohi');
        cy.get('.inventory_item_price').first().should('have.text', '$7.99');
    });
    it('Should complete checkout step one successfully', () => {
        // Đảm bảo đang ở inventory (beforeEach đã login)
        cy.url().should('include', '/inventory.html');

        // Add product
        cy.get('.inventory_item').first()
            .find('button')
            .click();

        // Go to cart
        cy.get('.shopping_cart_link').click();
        cy.url().should('include', '/cart.html');

        // Checkout
        cy.get('#checkout').click();
        cy.url().should('include', '/checkout-step-one.html');

        // Fill checkout info
        cy.get('#first-name').type('John');
        cy.get('#last-name').type('Doe');
        cy.get('#postal-code').type('12345');

        // Continue
        cy.get('#continue').click();

        // Verify step two
        cy.url().should('include', '/checkout-step-two.html');
    });

});
