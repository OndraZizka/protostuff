// Generated by http://code.google.com/p/protostuff/ ... DO NOT EDIT!
// Generated from group.proto

package io.protostuff;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

public final class Student implements Externalizable, Message<Student>
{

    public static Schema<Student> getSchema()
    {
        return SCHEMA;
    }

    public static Student getDefaultInstance()
    {
        return DEFAULT_INSTANCE;
    }

    static final Student DEFAULT_INSTANCE = new Student();

    // non-private fields
    // see http://developer.android.com/guide/practices/design/performance.html#package_inner
    String name;
    List<Club> club;

    public Student()
    {

    }

    // getters and setters

    // name

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    // club

    public List<Club> getClubList()
    {
        return club;
    }

    public void setClubList(List<Club> club)
    {
        this.club = club;
    }

    public Club getClub(int index)
    {
        return club == null ? null : club.get(index);
    }

    public int getClubCount()
    {
        return club == null ? 0 : club.size();
    }

    public void addClub(Club club)
    {
        if (this.club == null)
            this.club = new ArrayList<Club>();
        this.club.add(club);
    }

    // java serialization

    public void readExternal(ObjectInput in) throws IOException
    {
        GraphIOUtil.mergeDelimitedFrom(in, this, SCHEMA);
    }

    public void writeExternal(ObjectOutput out) throws IOException
    {
        GraphIOUtil.writeDelimitedTo(out, this, SCHEMA);
    }

    // message method

    public Schema<Student> cachedSchema()
    {
        return SCHEMA;
    }

    static final Schema<Student> SCHEMA = new Schema<Student>()
    {
        // schema methods

        public Student newMessage()
        {
            return new Student();
        }

        public Class<Student> typeClass()
        {
            return Student.class;
        }

        public String messageName()
        {
            return Student.class.getSimpleName();
        }

        public String messageFullName()
        {
            return Student.class.getName();
        }

        public boolean isInitialized(Student message)
        {
            return true;
        }

        public void mergeFrom(Input input, Student message) throws IOException
        {
            for (int number = input.readFieldNumber(this);; number = input.readFieldNumber(this))
            {
                switch (number)
                {
                    case 0:
                        return;
                    case 1:
                        message.name = input.readString();
                        break;
                    case 2:
                        if (message.club == null)
                            message.club = new ArrayList<Club>();
                        message.club.add(input.mergeObject(null, Club.getSchema()));
                        break;

                    default:
                        input.handleUnknownField(number, this);
                }
            }
        }

        public void writeTo(Output output, Student message) throws IOException
        {
            if (message.name != null)
                output.writeString(1, message.name, false);

            if (message.club != null)
            {
                for (Club club : message.club)
                {
                    if (club != null)
                        output.writeObject(2, club, Club.getSchema(), true);
                }
            }

        }

        public String getFieldName(int number)
        {
            switch (number)
            {
                case 1:
                    return "name";
                case 2:
                    return "club";
                default:
                    return null;
            }
        }

        public int getFieldNumber(String name)
        {
            final Integer number = fieldMap.get(name);
            return number == null ? 0 : number.intValue();
        }

        final java.util.HashMap<String, Integer> fieldMap = new java.util.HashMap<String, Integer>();

        {
            fieldMap.put("name", 1);
            fieldMap.put("club", 2);
        }
    };

}
