package com.example.student.groupassignment;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class Tutorial
{
  private String Description;
  private String ownerId;
  private java.util.Date Time;
  private java.util.Date created;
  private java.util.Date updated;
  private String Tutorial;
  private String objectId;
  public String getDescription()
  {
    return Description;
  }

  public void setDescription( String Description )
  {
    this.Description = Description;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public java.util.Date getTime()
  {
    return Time;
  }

  public void setTime( java.util.Date Time )
  {
    this.Time = Time;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String getTutorial()
  {
    return Tutorial;
  }

  public void setClass( String Tutorial )
  {
    this.Tutorial = Tutorial;
  }

  public String getObjectId()
  {
    return objectId;
  }

                                                    
  public Tutorial save()
  {
    return Backendless.Data.of( Tutorial.class ).save( this );
  }

  public Future<Tutorial> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Tutorial> future = new Future<Tutorial>();
      Backendless.Data.of( Tutorial.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<Tutorial> callback )
  {
    Backendless.Data.of( Tutorial.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Tutorial.class ).remove( this );
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
      Backendless.Data.of( Tutorial.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Tutorial.class ).remove( this, callback );
  }

  public static Tutorial findById( String id )
  {
    return Backendless.Data.of( Tutorial.class ).findById( id );
  }

  public static Future<Tutorial> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Tutorial> future = new Future<Tutorial>();
      Backendless.Data.of( Tutorial.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<Tutorial> callback )
  {
    Backendless.Data.of( Tutorial.class ).findById( id, callback );
  }

  public static Tutorial findFirst()
  {
    return Backendless.Data.of( Tutorial.class ).findFirst();
  }

  public static Future<Tutorial> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Tutorial> future = new Future<Tutorial>();
      Backendless.Data.of( Tutorial.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<Tutorial> callback )
  {
    Backendless.Data.of( Tutorial.class ).findFirst( callback );
  }

  public static Tutorial findLast()
  {
    return Backendless.Data.of( Tutorial.class ).findLast();
  }

  public static Future<Tutorial> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Tutorial> future = new Future<Tutorial>();
      Backendless.Data.of( Tutorial.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<Tutorial> callback )
  {
    Backendless.Data.of( Tutorial.class ).findLast( callback );
  }

  public static BackendlessCollection<Tutorial> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( Tutorial.class ).find( query );
  }

  public static Future<BackendlessCollection<Tutorial>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Tutorial>> future = new Future<BackendlessCollection<Tutorial>>();
      Backendless.Data.of( Tutorial.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Tutorial>> callback )
  {
    Backendless.Data.of( Tutorial.class ).find( query, callback );
  }
}