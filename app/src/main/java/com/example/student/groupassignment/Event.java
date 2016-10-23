package com.example.student.groupassignment;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class Event
{
  private java.util.Date updated;
  private java.util.Date created;
  private String ownerId;
  private String Name;
  private String objectId;
  private String Description;
  private java.util.Date EventTime;
  private Tutorial Tutorial;
  public java.util.Date getUpdated()
  {
    return updated;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public String getName()
  {
    return Name;
  }

  public void setName( String Name )
  {
    this.Name = Name;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getDescription()
  {
    return Description;
  }

  public void setDescription( String Description )
  {
    this.Description = Description;
  }

  public java.util.Date getEventTime()
  {
    return EventTime;
  }

  public void setEventTime( java.util.Date EventTime )
  {
    this.EventTime = EventTime;
  }

  public Tutorial getTutorial()
  {
    return Tutorial;
  }

  public void setTutorial( Tutorial Tutorial )
  {
    this.Tutorial = Tutorial;
  }

                                                    
  public Event save()
  {
    return Backendless.Data.of( Event.class ).save( this );
  }

  public Future<Event> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Event> future = new Future<Event>();
      Backendless.Data.of( Event.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<Event> callback )
  {
    Backendless.Data.of( Event.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Event.class ).remove( this );
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
      Backendless.Data.of( Event.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Event.class ).remove( this, callback );
  }

  public static Event findById( String id )
  {
    return Backendless.Data.of( Event.class ).findById( id );
  }

  public static Future<Event> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Event> future = new Future<Event>();
      Backendless.Data.of( Event.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<Event> callback )
  {
    Backendless.Data.of( Event.class ).findById( id, callback );
  }

  public static Event findFirst()
  {
    return Backendless.Data.of( Event.class ).findFirst();
  }

  public static Future<Event> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Event> future = new Future<Event>();
      Backendless.Data.of( Event.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<Event> callback )
  {
    Backendless.Data.of( Event.class ).findFirst( callback );
  }

  public static Event findLast()
  {
    return Backendless.Data.of( Event.class ).findLast();
  }

  public static Future<Event> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Event> future = new Future<Event>();
      Backendless.Data.of( Event.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<Event> callback )
  {
    Backendless.Data.of( Event.class ).findLast( callback );
  }

  public static BackendlessCollection<Event> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( Event.class ).find( query );
  }

  public static Future<BackendlessCollection<Event>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Event>> future = new Future<BackendlessCollection<Event>>();
      Backendless.Data.of( Event.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Event>> callback )
  {
    Backendless.Data.of( Event.class ).find( query, callback );
  }
}