package com.example.pamlab11

import com.google.gson.annotations.SerializedName




class IPInfo {
    @SerializedName("ip")
    private var ip: String? = null

    @SerializedName("hostname")
    private var hostname: String? = null

    @SerializedName("city")
    private var city: String? = null

    @SerializedName("region")
    private var region: String? = null

    @SerializedName("country")
    private var country: String? = null

    @SerializedName("loc")
    private var loc: String? = null

    @SerializedName("org")
    private var org: String? = null

    @SerializedName("postal")
    private var postal: String? = null

    @SerializedName("timezone")
    private var timezone: String? = null

    @SerializedName("readme")
    private var readme: String? = null
    fun getIp(): String? {
        return ip
    }

    fun setIp(ip: String?) {
        this.ip = ip
    }

    fun getHostname(): String? {
        return hostname
    }

    fun setHostname(hostname: String?) {
        this.hostname = hostname
    }

    fun getCity(): String? {
        return city
    }

    fun setCity(city: String?) {
        this.city = city
    }

    fun getRegion(): String? {
        return region
    }

    fun setRegion(region: String?) {
        this.region = region
    }

    fun getCountry(): String? {
        return country
    }

    fun setCountry(country: String?) {
        this.country = country
    }

    fun getLoc(): String? {
        return loc
    }

    fun setLoc(loc: String?) {
        this.loc = loc
    }

    fun getOrg(): String? {
        return org
    }

    fun setOrg(org: String?) {
        this.org = org
    }

    fun getPostal(): String? {
        return postal
    }

    fun setPostal(postal: String?) {
        this.postal = postal
    }

    fun getTimezone(): String? {
        return timezone
    }

    fun setTimezone(timezone: String?) {
        this.timezone = timezone
    }

    fun getReadme(): String? {
        return readme
    }

    fun setReadme(readme: String?) {
        this.readme = readme
    }
}