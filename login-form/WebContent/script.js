
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
            return 'Password must contain min 6 letter password, with at least a symbol, letters and a number.';
        }
    }