package com.example.student.groupassignment.entities;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

/**
 * Created by Aaron on 24/10/2016.
 * The User Class
 */

public class Users {

    public String email;
    public String ZID;
    public String name;
    public String type;
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZid() {
        return ZID;
    }

    public void setZid(String zid) {
        this.ZID = zid;
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
    public Users save()
    {
        return Backendless.Data.of( Users.class ).save( this );
    }

    public Future<Users> saveAsync()
    {
        if( Backendless.isAndroid() )
        {
            throw new UnsupportedOperationException( "Using this method is restricted in Android" );
        }
        else
        {
            Future<Users> future = new Future<Users>();
            Backendless.Data.of( Users.class ).save( this, future );

            return future;
        }
    }

    public void saveAsync( AsyncCallback<Users> callback )
    {
        Backendless.Data.of( Users.class ).save( this, callback );
    }

    public Long remove()
    {
        return Backendless.Data.of( Users.class ).remove( this );
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
            Backendless.Data.of( Users.class ).remove( this, future );

            return future;
        }
    }

    public void removeAsync( AsyncCallback<Long> callback )
    {
        Backendless.Data.of( Users.class ).remove( this, callback );
    }

    public static Users findById( String id )
    {
        return Backendless.Data.of( Users.class ).findById( id );
    }

    public static Future<Users> findByIdAsync( String id )
    {
        if( Backendless.isAndroid() )
        {
            throw new UnsupportedOperationException( "Using this method is restricted in Android" );
        }
        else
        {
            Future<Users> future = new Future<Users>();
            Backendless.Data.of( Users.class ).findById( id, future );

            return future;
        }
    }

    public static void findByIdAsync( String id, AsyncCallback<Users> callback )
    {
        Backendless.Data.of( Users.class ).findById( id, callback );
    }

    public static Users findFirst()
    {
        return Backendless.Data.of( Users.class ).findFirst();
    }

    public static Future<Users> findFirstAsync()
    {
        if( Backendless.isAndroid() )
        {
            throw new UnsupportedOperationException( "Using this method is restricted in Android" );
        }
        else
        {
            Future<Users> future = new Future<Users>();
            Backendless.Data.of( Users.class ).findFirst( future );

            return future;
        }
    }

    public static void findFirstAsync( AsyncCallback<Users> callback )
    {
        Backendless.Data.of( Users.class ).findFirst( callback );
    }

    public static Users findLast()
    {
        return Backendless.Data.of( Users.class ).findLast();
    }

    public static Future<Users> findLastAsync()
    {
        if( Backendless.isAndroid() )
        {
            throw new UnsupportedOperationException( "Using this method is restricted in Android" );
        }
        else
        {
            Future<Users> future = new Future<Users>();
            Backendless.Data.of( Users.class ).findLast( future );

            return future;
        }
    }

    public static void findLastAsync( AsyncCallback<Users> callback )
    {
        Backendless.Data.of( Users.class ).findLast( callback );
    }

    public static BackendlessCollection<Users> find(BackendlessDataQuery query )
    {
        return Backendless.Data.of( Users.class ).find( query );
    }

    public static Future<BackendlessCollection<Users>> findAsync( BackendlessDataQuery query )
    {
        if( Backendless.isAndroid() )
        {
            throw new UnsupportedOperationException( "Using this method is restricted in Android" );
        }
        else
        {
            Future<BackendlessCollection<Users>> future = new Future<BackendlessCollection<Users>>();
            Backendless.Data.of( Users.class ).find( query, future );

            return future;
        }
    }

    public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Users>> callback )
    {
        Backendless.Data.of( Users.class ).find( query, callback );
    }

}
