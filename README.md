#Linch Forms

Linch forms lets you create forms where you can define a list of validators for each field.

##Create a form

    Form userForm = new Form()
            .addField("username", new RequiredValidator(), new UserExistsValidator())
            .addField("firstName")
            .addField("lastName")
            .addField("email", new RequiredValidator(), new EmailValidator())
            .addField("password", new RequiredValidator())
            .addField("confirmPassword", new EqualsValidator("password"));

##Fill parameters from request and validate

    userForm.bind(parameterMap).validate();

    if (userForm.isValid()) {
        User user = new User();
        user.setUsername(userForm.get("username").getValue());
        user.setFirstName(userForm.get("firstName").getValue());
        user.setLastName(userForm.get("lastName").getValue());
        user.setEmail(userForm.get("email").getValue());
        user.setPassword(passwordEncryptor.encryptPassword(userForm.get("password").getValue()));
        userDao.save(user);

        // redirect to view
    } else {
        // redirect to form
    }

If the form is valid, save entity and redirect to view, otherwise render the form again and display the errors.


##Display errors in template

    <input type="text" class="form-control" id="username" name="username" value="{{form.username}}" required>
    {{#form.username.error}}<span class="help-block">{{.}}</span>{{/form.username.error}}


##Provide a Texter to define your own error messages for each validator and fieldName

    Form i18nForm = new Form(new Texter() {
        @Override
        public String getText(String fieldName, String validatorKey) {
            return i18n.getText("linch.error." + validatorKey + "." + fieldName);
        }
    });