/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package blade.gogo;

import com.liferay.portal.kernel.service.UserLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(
        property = {
                "osgi.command.scope=blade",
                "osgi.command.function=usercount"
        },
        service = Object.class
)
public class UserCountCommand {
    private UserLocalService _userLocalService;

    public void usercount() {
        System.out.println("# of users: " + getUserLocalService().getUsersCount());
    }

    public UserLocalService getUserLocalService() {
        return _userLocalService;
    }

    @Reference
    public void setUserLocalService(UserLocalService _userLocalService) {
        this._userLocalService = _userLocalService;
    }
}
