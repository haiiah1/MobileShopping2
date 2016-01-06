/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author congt
 */
@Entity
@Table(name = "news")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "News.findAll", query = "SELECT n FROM News n"),
    @NamedQuery(name = "News.findByNewsID", query = "SELECT n FROM News n WHERE n.newsID = :newsID"),
    @NamedQuery(name = "News.findByTitle", query = "SELECT n FROM News n WHERE n.title = :title"),
    @NamedQuery(name = "News.findByPublishDate", query = "SELECT n FROM News n WHERE n.publishDate = :publishDate")})
public class News implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NewsID")
    private Integer newsID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Title")
    private String title;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Content")
    private String content;
    @Column(name = "PublishDate")
    @Temporal(TemporalType.DATE)
    private Date publishDate;

    public News() {
    }

    public News(Integer newsID) {
        this.newsID = newsID;
    }

    public News(Integer newsID, String title) {
        this.newsID = newsID;
        this.title = title;
    }

    public Integer getNewsID() {
        return newsID;
    }

    public void setNewsID(Integer newsID) {
        this.newsID = newsID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (newsID != null ? newsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof News)) {
            return false;
        }
        News other = (News) object;
        if ((this.newsID == null && other.newsID != null) || (this.newsID != null && !this.newsID.equals(other.newsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobile.entity.News[ newsID=" + newsID + " ]";
    }
    
}
