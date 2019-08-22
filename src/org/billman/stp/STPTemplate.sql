/* ****************************************************************************
 * (c) COPYRIGHT QC Software, LLC. ${date?date?string("yyyy")} All Rights Reserved
 * No part of this copyrighted work may be reproduced, modified, or distributed
 * in any form or by any means without the prior written permission of
 * QC Software, LLC.
 *
 * $Id$
 *****************************************************************************/

/******************************************************************************
 * procedure ${name}
 *
 * $Id$
 *****************************************************************************/
create or replace procedure ${name}(<#if paramInfo == "">)<#else>
  ${paramInfo})</#if>
begin
end;

grant execute on ${name} to qcUsers