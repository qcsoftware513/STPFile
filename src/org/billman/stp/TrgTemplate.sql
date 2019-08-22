/* ****************************************************************************
 * (c) COPYRIGHT QC Software, LLC. ${date?date?string("yyyy")} All Rights Reserved
 * No part of this copyrighted work may be reproduced, modified, or distributed
 * in any form or by any means without the prior written permission of
 * QC Software, LLC.
 *
 * $Id$
 *****************************************************************************/

/******************************************************************************
 * trigger ${name}
 *
 * $Id$
 *****************************************************************************/
create or replace trigger ${name}
  ${beforeOrAfter} ${updateEvent} on ${tableName}
  referencing old as oldRec
              new as newRec
  for each row
begin
end;