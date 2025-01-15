package dev.saseum.springboot_boilerplate_v1.service;

import dev.saseum.springboot_boilerplate_v1.entity.Setting;
import dev.saseum.springboot_boilerplate_v1.repository.SettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SettingService {
    private final SettingRepository settingRepository;

    public Setting create() {
        return settingRepository.save(Setting.builder().key("foo").value("bar").build());
    }
}
