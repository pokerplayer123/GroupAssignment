package com.example.student.groupassignment.Backendless;

import android.content.Context;
import android.util.Patterns;
import android.widget.Toast;

import com.example.student.groupassignment.R;

/**
 * Provides static methods for different value validators.
 * Shows Toasts with warnings if validation fails.
 * Backendless login/registration was implemented based on RestaurantToGo repository provided by Backendless
 * as a guideline to using their API and can be found here https://github.com/Backendless/RestaurantToGo
 */
public class Validator
{
  /**
   * Validates user's name: checks whether it is not empty and whether the first letter is in uppercase.
   * Shows Toast with a warning if validation fails.
   *
   * @param currentContext context, in which validation occurs
   * @param name           user's name to be validated
   * @return true if name is valid, false if validation failed
   */
  public static boolean isNameValid(Context currentContext, CharSequence name )
  {
    if( name.toString().isEmpty() )
    {
      Toast.makeText( currentContext, currentContext.getString( R.string.warning_name_empty ), Toast.LENGTH_LONG ).show();
      return false;
    }

    if( !Character.isUpperCase( name.charAt( 0 ) ) )
    {
      Toast.makeText( currentContext, currentContext.getString( R.string.warning_name_lowercase ), Toast.LENGTH_LONG ).show();
      return false;
    }

    return true;
  }

  /**
   * Validates email: checks whether it is not empty and whether it matches Patterns.EMAIL_ADDRESS regex.
   * Shows Toast with a warning if validation fails.
   *
   * @param currentContext context, in which validation occurs
   * @param email          email to be validated
   * @return true if email is valid, false if validation failed
   */
  public static boolean isEmailValid(Context currentContext, CharSequence email )
  {
    if( email.toString().isEmpty() )
    {
      Toast.makeText( currentContext, currentContext.getString( R.string.warning_email_empty ), Toast.LENGTH_LONG ).show();
      return false;
    }

    if( !Patterns.EMAIL_ADDRESS.matcher( email ).matches() )
    {
      Toast.makeText( currentContext, currentContext.getString( R.string.warning_email_invalid ), Toast.LENGTH_LONG ).show();
      return false;
    }

    return true;
  }

  /**
   * Validates password: checks whether it is not empty.
   * Shows Toast with a warning if validation fails.
   *
   * @param currentContext context, in which validation occurs
   * @param password       password to be validated
   * @return true if password is valid, false if validation failed
   */
  public static boolean isPasswordValid(Context currentContext, CharSequence password )
  {
    if( password.toString().isEmpty() )
    {
      Toast.makeText( currentContext, currentContext.getString( R.string.warning_password_empty ), Toast.LENGTH_LONG ).show();
      return false;
    }

    return true;
  }

  public static boolean isZIDValid(Context currentContext, CharSequence ZID) {
    if (ZID.toString().isEmpty()) {
      Toast.makeText(currentContext, "ZID is required", Toast.LENGTH_LONG).show();
      return false;
    }
    return true;
    }
  }

