package com.huawei.vodafone.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class MessageInfo implements Parcelable, Comparable<MessageInfo>
{
    private String queueId;
    
    /**
     * 标识
     */
    private String id;
    
    /**
     * 标题
     */
    private String title;
    
    /**
     * 内容
     */
    private String content = "";
    
    /**
     * 图片key
     */
    private String image = "";
    
    /**
     * 消息类型
     */
    private String pattern;
    
    /**
     * 创建时间
     */
    private String createtime;
    
    private String productId;
    
    // 消息状态 默认0发送成功 1发送失败
    private String sendStatus = "0";
    
    private User sender = new User();
    
    private String localImage = "";
    
    public MessageInfo()
    {
        
    }
    
    public String getLocalImage()
    {
        return localImage;
    }
    
    public void setLocalImage(String localImage)
    {
        this.localImage = localImage;
    }
    
    public String getQueueId()
    {
        return queueId;
    }
    
    public void setQueueId(String queueId)
    {
        this.queueId = queueId;
    }
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public String getContent()
    {
        return content;
    }
    
    public void setContent(String content)
    {
        this.content = content;
    }
    
    public String getImage()
    {
        return image;
    }
    
    public void setImage(String image)
    {
        this.image = image;
    }
    
    public String getPattern()
    {
        return pattern;
    }
    
    public void setPattern(String pattern)
    {
        this.pattern = pattern;
    }
    
    public String getCreatetime()
    {
        return createtime;
    }
    
    public void setCreatetime(String createtime)
    {
        this.createtime = createtime;
    }
    
    
    public User getSender()
    {
        return sender;
    }
    
    public void setSender(User sender)
    {
        this.sender = sender;
    }
    
    public String getProductId()
    {
        return productId;
    }
    
    public void setProductId(String productId)
    {
        this.productId = productId;
    }
    
    public String getSendStatus()
    {
        return sendStatus;
    }
    
    public void setSendStatus(String sendStatus)
    {
        this.sendStatus = sendStatus;
    }
    
    @Override
    public int describeContents()
    {
        // TODO Auto-generated method stub
        return 0;
    }
    
    public static final Parcelable.Creator<MessageInfo> CREATOR = new Parcelable.Creator<MessageInfo>()
    {
        public MessageInfo createFromParcel(Parcel source)
        {
            return new MessageInfo(source);
        }
        
        public MessageInfo[] newArray(int size)
        {
            return new MessageInfo[size];
        }
    };
    
    public MessageInfo(Parcel in)
    {
        queueId = in.readString();
        id = in.readString();
        title = in.readString();
        content = in.readString();
        image = in.readString();
        pattern = in.readString();
        createtime = in.readString();
        productId = in.readString();
        sendStatus = in.readString();
        localImage = in.readString();
    }
    
    @Override
    public void writeToParcel(Parcel out, int flags)
    {
        // TODO Auto-generated method stub
        out.writeString(queueId);
        out.writeString(id);
        out.writeString(title);
        out.writeString(content);
        out.writeString(image);
        out.writeString(pattern);
        out.writeString(createtime);
        out.writeString(productId);
        out.writeString(sendStatus);
        out.writeString(localImage);
    }
    
    @Override
    public int compareTo(MessageInfo another)
    {
        // TODO Auto-generated method stub
        return this.getId().compareTo(another.getId());
    }
    
}
