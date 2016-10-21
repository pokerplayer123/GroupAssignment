package com.example.student.groupassignment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;

/**
 * Handles registration flow.
 */
public class RegistrationActivity extends Activity
{
  @Override
  protected void onCreate( Bundle savedInstanceState )
  {
    super.onCreate( savedInstanceState );
    setContentView( R.layout.activity_registration );

    Backendless.initApp( this, BackendSettings.app_id, BackendSettings.SECRET_KEY, BackendSettings.appVersion);

    Button registerButton = (Button) findViewById( R.id.registerButton );

    View.OnClickListener registerButtonClickListener = createRegisterButtonClickListener();

    registerButton.setOnClickListener( registerButtonClickListener );
  }

  /**
   * Validates the values, which user entered on registration screen.
   * Shows Toast with a warning if something is wrong.
   *
   * @param name            user's name
   * @param email           user's email
   * @param password        user's password
   * @param passwordConfirm user's password confirmation
   * @return true if all values are OK, false if something is wrong
   */
  public boolean isRegistrationValuesValid(CharSequence name, CharSequence email, CharSequence password,
                                           CharSequence passwordConfirm )
  {
    return Validator.isNameValid( this, name )
            && Validator.isEmailValid( this, email )
            && Validator.isPasswordValid( this, password )
            && isPasswordsMatch( password, passwordConfirm );
  }

  /**
   * Determines whether password and password confirmation are the same.
   * Displays Toast with a warning if not.
   *
   * @param password        password
   * @param passwordConfirm password confirmation
   * @return true if password and password confirmation match, else false
   */
  public boolean isPasswordsMatch(CharSequence password, CharSequence passwordConfirm )
  {
    if( !TextUtils.equals( password, passwordConfirm ) )
    {
      Toast.makeText( this, getString( R.string.warning_passwords_do_not_match ), Toast.LENGTH_LONG ).show();
      return false;
    }

    return true;
  }

  /**
   * Sends a request to Backendless to register user.
   *
   * @param name                 user's name
   * @param email                user's email
   * @param password             user's password
   * @param registrationCallback a callback, containing actions to be executed on request result
   */
  public void registerUser(String name, String email, String password,
                           AsyncCallback<BackendlessUser> registrationCallback )
  {
    BackendlessUser user = new BackendlessUser();
    user.setEmail( email );
    user.setPassword( password );
    user.setProperty( "name", name );

    //Backendless handles password hashing by itself, so we don't need to send hash instead of plain text
    Backendless.UserService.register( user, registrationCallback );
  }

  /**
   * Creates a callback, containing actions to be executed on registration request result.
   * Sends result intent containing registered user's email to calling activity on success.
   *
   * @return a callback, containing actions to be executed on registration request result
   */
  public LoadingCallback<BackendlessUser> createRegistrationCallback()
  {
    return new LoadingCallback<BackendlessUser>( this, getString( R.string.loading_register ) )
    {
      @Override
      public void handleResponse( BackendlessUser registeredUser )
      {
        super.handleResponse( registeredUser );
        Intent registrationResult = new Intent();
        registrationResult.putExtra( BackendlessUser.EMAIL_KEY, registeredUser.getEmail() );
        setResult( RESULT_OK, registrationResult );
        RegistrationActivity.this.finish();
      }
    };
  }

  /**
   * Creates a listener, which proceeds with registration on button click.
   *
   * @return a listener, handling registration button click
   */
  public View.OnClickListener createRegisterButtonClickListener()
  {
    return new View.OnClickListener()
    {
      @Override
      public void onClick( View v )
      {
        EditText nameField = (EditText) findViewById( R.id.nameField );
        EditText emailField = (EditText) findViewById( R.id.emailField );
        EditText passwordField = (EditText) findViewById( R.id.passwordField );
        EditText passwordConfirmField = (EditText) findViewById( R.id.passwordConfirmField );

        CharSequence name = nameField.getText();
        CharSequence email = emailField.getText();
        CharSequence password = passwordField.getText();
        CharSequence passwordConfirmation = passwordConfirmField.getText();

        if( isRegistrationValuesValid( name, email, password, passwordConfirmation ) )
        {
          LoadingCallback<BackendlessUser> registrationCallback = createRegistrationCallback();

          registrationCallback.showLoading();
          registerUser( name.toString(), email.toString(), password.toString(), registrationCallback );
        }
      }
    };
  }
}
