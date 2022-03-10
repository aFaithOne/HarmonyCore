package me.lumenowaty.harmonycore.components;

import me.lumenowaty.harmonycore.components.collections.HList;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class HPlayer {

    private final String initialIP;
    private final HList<String> usedIP;
    private final LocalDateTime initialDate;
    private final LocalDateTime lastJoinDate;
    private final UUID uuid;
    private final boolean premiumClient;
    private String mail;

    public HPlayer(String initialIP, HList<String> usedIP, LocalDateTime initialDate, LocalDateTime lastJoinDate, UUID uuid, boolean premiumClient) {
        this.initialIP = initialIP;
        this.usedIP = usedIP;
        this.initialDate = initialDate;
        this.lastJoinDate = lastJoinDate;
        this.uuid = uuid;
        this.premiumClient = premiumClient;
    }

    public HPlayer(String initialIP, HList<String> usedIP, LocalDateTime initialDate, LocalDateTime lastJoinDate, UUID uuid, boolean premiumClient, String mail) {
        this.initialIP = initialIP;
        this.usedIP = usedIP;
        this.initialDate = initialDate;
        this.lastJoinDate = lastJoinDate;
        this.uuid = uuid;
        this.premiumClient = premiumClient;
        this.mail = mail;
    }

    public String getInitialIP() {
        return initialIP;
    }

    public HList<String> getUsedIP() {
        return usedIP;
    }

    public LocalDateTime getInitialDate() {
        return initialDate;
    }

    public LocalDateTime getLastJoinDate() {
        return lastJoinDate;
    }

    public UUID getUuid() {
        return uuid;
    }

    public boolean isPremiumClient() {
        return premiumClient;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HPlayer hPlayer = (HPlayer) o;
        return premiumClient == hPlayer.premiumClient
                && initialIP.equals(hPlayer.initialIP)
                && usedIP.equals(hPlayer.usedIP)
                && initialDate.equals(hPlayer.initialDate)
                && lastJoinDate.equals(hPlayer.lastJoinDate)
                && uuid.equals(hPlayer.uuid)
                && Objects.equals(mail, hPlayer.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(initialIP, usedIP, initialDate, lastJoinDate, uuid, premiumClient, mail);
    }
}
