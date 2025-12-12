package com.automation.api.builders;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Connection {

    private String id;
    private String name;
    private String connectorId;
    private String driverId;
    private String serviceProviderName;
    private String authTypeId;
    private String type;
    private String secretId;
    private boolean useVault;
    private String createdBy;
    private String updatedBy;
    private String createdTimestamp;
    private String updatedTimestamp;
    private String status;
    private String accountId;
    private String organizationId;
    private String workspaceId;
    private int deleted;
    private String serverInstanceName;
    private String sslSecretId;

    private List<ConnectionProperty> connectionProperties;
    private List<Activity> activities;
    private List<JaasProperty> jaasProperties;

    private ServerConfig serverConfig;
    private AuthConfig authConfig;

    private String field;
    private List<String> values;

    // --- inner classes ---

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ConnectionProperty {
        private String name;
        private String value;
        private String type;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Activity {
        private String id;
        private String taskStatus;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JaasProperty {
        private String name;
        private String value;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ServerConfig {
        private boolean useJDBCurl;
        private String jdbcUrl;
        private Info info;
        private int vaultVersion;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Info {
            private String host;
            private String port;
            private String database;
            private String warehouse;
            private String accountIdentifier;
            private String fileType;
            private String container;
            private String folderPath;
            private String region;
            private String domainName;
            private String instanceName;
        }
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AuthConfig {
        private String username;
        private String password;
        private String privateKeyPassphrase;
        private String privateKeyContentBase64Encoded;
        private String privateKeySecretName;
        private String privateKeyPasswordSecretName;
        private String clientId;
        private String tenantId;
        private String clientSecret;

        private String keyVaultName;

        private String awsAccessKey;
        private String awsSecretKey;
        private String awsSessionToken;

        private String azureAccount;
        private String azureAccessKey;

        private String securityToken;

        private String krbPrincipal;

        private String oauthClientId;
        private String oauthClientSecret;

        private String keytabFilePath;
        private String ticketCacheFileName;
    }
}
