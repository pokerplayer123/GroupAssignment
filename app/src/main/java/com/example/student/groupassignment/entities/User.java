package com.example.student.groupassignment.entities;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

/**
 * Created by Aaron on 24/10/2016.
 * The User Class
 */

public class User {

    public String email;
    public String zid;
    public String name;
    public String type;

    public User(String email, String zid, String, String name, String type){
        this.email = email;
        this.zid =zid;
        this.name = name;
        this.type = type;

    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZid() {
        return zid;
    }

    public void setZid(String zid) {
        this.zid = zid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public User save()
    {
        return Backendless.Data.of( User.class ).save( this );
    }

    public Future<User> saveAsync()
    {
        if( Backendless.isAndroid() )
        {
            throw new UnsupportedOperationException( "Using this method is restricted in Android" );
        }
        else
        {
            Future<User> future = new Future<User>();
            Backendless.Data.of( User.class ).save( this, future );

            return future;
        }
    }

    public void saveAsync( AsyncCallback<User> callback )
    {
        Backendless.Data.of( User.class ).save( this, callback );
    }

    public Long remove()
    {
        return Backendless.Data.of( User.class ).remove( this );
    }

    public Future<Long> removeAsync()
    {
        if( Backendless.isAndroid() )
        {
            throw new UnsupportedOperationException( "Using this method is restricted in Android" );
        }
        else
        {
            Future<Long> future = new Future<Long>();
            Backendless.Data.of( User.class ).remove( this, future );

            return future;
        }
    }

    public void removeAsync( AsyncCallback<Long> callback )
    {
        Backendless.Data.of( User.class ).remove( this, callback );
    }

    public static User findById( String id )
    {
        return Backendless.Data.of( User.class ).findById( id );
    }

    public static Future<User> findByIdAsync( String id )
    {
        if( Backendless.isAndroid() )
        {
            throw new UnsupportedOperationException( "Using this method is restricted in Android" );
        }
        else
        {
            Future<User> future = new Future<User>();
            Backendless.Data.of( User.class ).findById( id, future );

            return future;
        }
    }

    public static void findByIdAsync( String id, AsyncCallback<User> callback )
    {
        Backendless.Data.of( User.class ).findById( id, callback );
    }

    public static User findFirst()
    {
        return Backendless.Data.of( User.class ).findFirst();
    }

    public static Future<User> findFirstAsync()
    {
        if( Backendless.isAndroid() )
        {
            throw new UnsupportedOperationException( "Using this method is restricted in Android" );
        }
        else
        {
            Future<User> future = new Future<User>();
            Backendless.Data.of( User.class ).findFirst( future );

            return future;
        }
    }

    public static void findFirstAsync( AsyncCallback<User> callback )
    {
        Backendless.Data.of( User.class ).findFirst( callback );
    }

    public static User findLast()
    {
        return Backendless.Data.of( User.class ).findLast();
    }

    public static Future<User> findLastAsync()
    {
        if( Backendless.isAndroid() )
        {
            throw new UnsupportedOperationException( "Using this method is restricted in Android" );
        }
        else
        {
            Future<User> future = new Future<User>();
            Backendless.Data.of( User.class ).findLast( future );

            return future;
        }
    }

    public static void findLastAsync( AsyncCallback<User> callback )
    {
        Backendless.Data.of( User.class ).findLast( callback );
    }

    public static BackendlessCollection<User> find(BackendlessDataQuery query )
    {
        return Backendless.Data.of( User.class ).find( query );
    }

    public static Future<BackendlessCollection<User>> findAsync( BackendlessDataQuery query )
    {
        if( Backendless.isAndroid() )
        {
            throw new UnsupportedOperationException( "Using this method is restricted in Android" );
        }
        else
        {
            Future<BackendlessCollection<User>> future = new Future<BackendlessCollection<User>>();
            Backendless.Data.of( User.class ).find( query, future );

            return future;
        }
    }

    public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<User>> callback )
    {
        Backendless.Data.of( User.class ).find( query, callback );
    }
}
