package com.study.accounts.Domain.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {
    /**
     * Returns the current auditor of the application.
     *
     * @return an Optional containing the username of the current auditor, or an empty Optional if no auditor is available.
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        // You can implement your logic to retrieve the current auditor here.
        // For example, you might want to get the username from the security context.
        // In this example, we are returning a fixed username for demonstration purposes.
        return Optional.of("system-account");
    }
}
