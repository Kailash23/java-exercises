var loginForm = document.forms.login;
loginForm.elements.email.placeholder = 'test@example.com';

var validation = {
    validateEmail: function() {
        var email = loginForm.elements.email.value;
        var text = this.emailMessage(email);

        if (email.length > 0) {
            var message = document.querySelector('.email_error');
            message.innerText = text;
        } else {
            var message = document.querySelector('.email_error');
            message.innerText = "";
        }
    },
    validatePassword: function() {
        var password = loginForm.elements.password.value;
        var text = this.passwordMessage(password);

        if (password.length > 0) {
            var message = document.querySelector('.pass_error');
            message.innerText = text;
        } else {
            var message = document.querySelector('.pass_error');
            message.innerText = "";
        }
    },
    emailMessage: function(email) {

        var regexEmail = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

        if (regexEmail.test(email)) {
            return '';
        }
        return 'Invalid email';
    },
    passwordMessage: function(password) {

        var regexPassword = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,16}$/;

        if (regexPassword.test(password)) {
            return '';
        }

        if (password.length < 6) {
            return 'Minimum 6 character required!';
        }

        var alphabets = /^[A-Za-z]+$/;
        if (alphabets.test(password)) {
            return 'Atleast single special character and digit is required!';
        }

        var specialChar = /[-!$%^&*()_+|~=`{}\[\]:\/;<>?,.@#a-zA-Z]/;
        if (specialChar.test(password)) {
            return 'Password must contain atleast single digit!';
        }

        var alphaNumeric = /^[a-z0-9]+$/i;
        if (alphaNumeric.test(password)) {
            return 'Atleast single special character is required!';
        }

        return 'Password must contain min 6 letter password, with at least a symbol, letters and a number.';
    }
}